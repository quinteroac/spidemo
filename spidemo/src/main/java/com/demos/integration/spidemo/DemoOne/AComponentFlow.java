package com.demos.integration.spidemo.DemoOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.xml.transformer.AbstractXmlTransformer;
import org.springframework.integration.xml.transformer.MarshallingTransformer;
import org.springframework.integration.xml.transformer.ResultToStringTransformer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import com.demos.integration.spidemo.DemoOne.domain.Sucursales;
import com.demos.integration.spidemo.DemoOne.domain.SucursalesRowMapperImpl;

//@Configuration
//@EnableIntegration
//@IntegrationComponentScan
//@ComponentScan
public class AComponentFlow {
	
/*	@Autowired
	private DriverManagerDataSource dataSource;

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata defaultPoller() {

	    PollerMetadata pollerMetadata = new PollerMetadata();
	    pollerMetadata.setTrigger(new PeriodicTrigger(100000));
	    return pollerMetadata;
	}
	
	@Bean
	public MessageSource<Object> jdbcMessageSource() {
		JdbcPollingChannelAdapter adapter = new JdbcPollingChannelAdapter(this.dataSource, "SELECT * FROM sucursales");
		adapter.setRowMapper(new SucursalesRowMapperImpl());
	    return adapter;
	}
	
	@Bean
	public MessageChannel aChannel() {
	    return MessageChannels.queue().get();
	}
	
	@Bean
	public XStreamMarshaller marshaller() {
		return new XStreamMarshaller();
	}

	
	@Bean
	public MarshallingTransformer bComponent() throws ParserConfigurationException {
		MarshallingTransformer bTransformer;
		bTransformer = new MarshallingTransformer(marshaller(), new ResultToStringTransformer());
		bTransformer.setResultType(AbstractXmlTransformer.STRING_RESULT);
		return bTransformer;
	}

	
	@Bean
	public MessageChannel bChannel() {
	    return MessageChannels.queue().get();
	}
	

	@Bean
	public IntegrationFlow pollingFlow() throws ParserConfigurationException {
	    return IntegrationFlows.from(jdbcMessageSource(),
	                c -> c.poller(Pollers.fixedRate(10000).maxMessagesPerPoll(1)))
	           .channel("aChannel")
	           .transform(bComponent())	           
	    	  // .channel("bChannel")
	    	 //  .handle(System.out::println)
	           .get();
	}	
	*/
}
