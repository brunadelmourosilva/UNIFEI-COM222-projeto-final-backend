package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.response.UpdateUserResponse;
import br.com.unifei.projetoclinica.dto.response.UserResponse;
import br.com.unifei.projetoclinica.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

  UpdateUserResponse mapUserEntityToUserResponse(User user);
  List<UserResponse> mapUserEntityToUserResponse(List<User> users);

  @Mapping(source = "clinic.id", target = "clinicId")
  UserResponse mapUserEntityToUserResponseUnique(User user);
}
