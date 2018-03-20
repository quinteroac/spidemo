package com.demos.integration.spidemo.DemoOne;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.xml.transformer.AbstractXmlTransformer;
import org.springframework.integration.xml.transformer.MarshallingTransformer;
import org.springframework.integration.xml.transformer.ResultToStringTransformer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.scheduling.support.PeriodicTrigger;

import com.demos.integration.spidemo.DemoOne.domain.SucursalesRowMapperImpl;

@Configuration
@EnableIntegration
public class AComponent {
	
	@Autowired
	private DriverManagerDataSource dataSource;
	
	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata defaultPoller() {

	    PollerMetadata pollerMetadata = new PollerMetadata();
	    pollerMetadata.setTrigger(new PeriodicTrigger(100000));
	    return pollerMetadata;
	}

	
	@Bean
	public PollableChannel aChannel() {
	    return MessageChannels.queue().get();
	}

	@Bean
	@InboundChannelAdapter(value="aChannel", poller= @Poller(fixedDelay="1000"))
	public MessageSource<Object> jdbcMessageSource() {
		JdbcPollingChannelAdapter adapter = new JdbcPollingChannelAdapter(this.dataSource, "SELECT * FROM sucursales");
		adapter.setRowMapper(new SucursalesRowMapperImpl());
	    return adapter;
	}
	
	
	@Bean
	public CastorMarshaller marshaller() {
		return new CastorMarshaller();
	}


	@Bean
	@Transformer (inputChannel="aChannel", outputChannel="bChannel")
	public MarshallingTransformer bComponent() throws ParserConfigurationException {
		MarshallingTransformer bTransformer;
		bTransformer = new MarshallingTransformer(marshaller(), new ResultToStringTransformer());
		bTransformer.setResultType(AbstractXmlTransformer.STRING_RESULT);
		return bTransformer;
	}
	
	@Bean
	public PollableChannel bChannel() {
	    return MessageChannels.queue().get();
	}

}
