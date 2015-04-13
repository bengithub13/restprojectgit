package com.restproject.service;



import com.restproject.dto.AddressesDTO;


public interface HomeAddressService {
public AddressesDTO getAllAddressListByZipCode(String zipCode);
public AddressesDTO getAllAddressList();
}
