package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.response.UpdateUserResponse;
import br.com.unifei.projetoclinica.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

  UpdateUserResponse mapUserEntityToUserResponse(User user);
  List<UpdateUserResponse> mapUserEntityToUserResponse(List<User> users);
}
