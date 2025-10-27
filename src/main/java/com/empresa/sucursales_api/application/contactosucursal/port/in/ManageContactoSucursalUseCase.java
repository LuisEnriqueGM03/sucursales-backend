package com.empresa.sucursales_api.application.contactosucursal.port.in;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalRequest;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalResponse;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalUpdateRequest;
import java.util.List;
public interface ManageContactoSucursalUseCase {
    ContactoSucursalResponse createContacto(ContactoSucursalRequest request);
    ContactoSucursalResponse getContactoById(Long id);
    List<ContactoSucursalResponse> getAllContactos();
    List<ContactoSucursalResponse> getContactosBySucursalId(Long sucursalId);
    ContactoSucursalResponse updateContacto(Long id, ContactoSucursalUpdateRequest request);
    void deleteContacto(Long id);
}
