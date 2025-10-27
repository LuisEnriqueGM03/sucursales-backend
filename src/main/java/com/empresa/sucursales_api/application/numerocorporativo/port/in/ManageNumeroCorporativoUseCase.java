package com.empresa.sucursales_api.application.numerocorporativo.port.in;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoRequest;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoResponse;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoUpdateRequest;
import java.util.List;
public interface ManageNumeroCorporativoUseCase {
    NumeroCorporativoResponse createNumero(NumeroCorporativoRequest request);
    NumeroCorporativoResponse getNumeroById(Long id);
    NumeroCorporativoResponse getNumeroByNumero(String numero);
    List<NumeroCorporativoResponse> getAllNumeros();
    List<NumeroCorporativoResponse> getNumerosBySucursalId(Long sucursalId);
    List<NumeroCorporativoResponse> getNumerosByPersonalId(Long personalId);
    NumeroCorporativoResponse updateNumero(Long id, NumeroCorporativoUpdateRequest request);
    NumeroCorporativoResponse assignToPersonal(Long id, Long personalId);
    NumeroCorporativoResponse unassignFromPersonal(Long id);
    void deleteNumero(Long id);
}
