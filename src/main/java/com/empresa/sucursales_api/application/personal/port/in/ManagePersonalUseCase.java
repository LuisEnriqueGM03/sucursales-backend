package com.empresa.sucursales_api.application.personal.port.in;
import com.empresa.sucursales_api.application.personal.dto.PersonalRequest;
import com.empresa.sucursales_api.application.personal.dto.PersonalResponse;
import com.empresa.sucursales_api.application.personal.dto.PersonalUpdateRequest;
import java.util.List;
public interface ManagePersonalUseCase {
    PersonalResponse createPersonal(PersonalRequest request);
    PersonalResponse getPersonalById(Long id);
    List<PersonalResponse> getAllPersonal();
    List<PersonalResponse> getActivePersonal();
    List<PersonalResponse> getPersonalBySucursalId(Long sucursalId);
    PersonalResponse updatePersonal(Long id, PersonalUpdateRequest request);
    void deletePersonal(Long id);
    void deactivatePersonal(Long id);
}
