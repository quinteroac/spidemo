package com.demos.integration.spidemo.DemoOne.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SucursalesRowMapperImpl implements RowMapper<Sucursales> {

	@Override
	public Sucursales mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sucursales sucursal = new Sucursales();
		sucursal.setAlmacen(rs.getString("almacen"));
		sucursal.setDomicilio1(rs.getString("domicilio1"));
		sucursal.setDomicilio2(rs.getString("domicilio2"));
		sucursal.setEstado(rs.getString("estado"));
		sucursal.setLatitud(rs.getString("latitud"));
		sucursal.setLongitud(rs.getString("longitud"));
		sucursal.setMunicipio(rs.getString("municipio"));
		sucursal.setPais(rs.getString("pais"));
		sucursal.setSnombre(rs.getString("snombre"));
		sucursal.setSucursal(rs.getShort("sucursal"));
		return sucursal;
	}

}
