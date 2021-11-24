package com.everis.spring.services;

import com.everis.spring.repository.EverisCustomer;

import antlr.collections.List;

public interface EverisCustomerManagementServiceI {

	/**
	 * Añade un nuevo cliente.
	 * 
	 * @param newCustomer
	 * @return EverisCustomer
	 */
	public EverisCustomer insertNewCustomer(final EverisCustomer newCustomer);

	/**
	 * Consulta todos los clientes.
	 */
	public void searchAllCustomers();

	/**
	 * Búsqueda por nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 */
	public void searchByFullName(final String name, final String surname1, final String surname2);

	/**
	 * Búsqueda por nombre.
	 * 
	 * @param name
	 */
	public void searchByName(final String name);
	
	public java.util.List getAllCustomers();

	java.util.List<EverisCustomer> findByFullName(String name, String surname1, String surname2);

}
