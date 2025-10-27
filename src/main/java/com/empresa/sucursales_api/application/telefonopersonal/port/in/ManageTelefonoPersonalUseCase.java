package com.empresa.sucursales_api.application.telefonopersonal.port.in;

import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalRequest;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalResponse;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalUpdateRequest;

import java.util.List;

/**
 * Puerto de entrada para la gestión de teléfonos del personal
 */
public interface ManageTelefonoPersonalUseCase {
    
    TelefonoPersonalResponse createTelefono(TelefonoPersonalRequest request);
    
    TelefonoPersonalResponse getTelefonoById(Long id);
    
    List<TelefonoPersonalResponse> getAllTelefonos();
    
    List<TelefonoPersonalResponse> getTelefonosByPersonalId(Long personalId);
    
    TelefonoPersonalResponse updateTelefono(Long id, TelefonoPersonalUpdateRequest request);
    
    void deleteTelefono(Long id);
}
