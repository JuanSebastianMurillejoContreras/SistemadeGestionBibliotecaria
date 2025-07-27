package com.biblioteca.sistemadegestionbibliotecaria.usuario.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.usuario.constants.UsuarioErrorMessage;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.dto.input.UsuarioCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.dto.input.UsuarioDTO;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.entity.UsuarioEntity;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.exception.UsuarioException;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.mapper.IUsuarioMapper;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.repository.IUsuarioRepo;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepo usuarioRepo;
    private final IUsuarioMapper usuarioMapper;

    @Override
        public UsuarioDTO createUsuario(UsuarioCreateDTO usuarioCreateDTO) {

        List<String> errors = new ArrayList<>();

        if (usuarioRepo.existsByName(usuarioCreateDTO.name()))
           errors.add(UsuarioErrorMessage.USER_NAME_ALREADY_REGISTERED + ": " + usuarioCreateDTO.name());

        if (usuarioRepo.existsByEmail(usuarioCreateDTO.email()))
            errors.add(UsuarioErrorMessage.USER_EMAIL_ALREADY_REGISTERED + ": " + usuarioCreateDTO.email());

        if(!errors.isEmpty()) throw new UsuarioException(String.join("; ", errors));

        UsuarioEntity usuarioEntity = usuarioMapper.UsuarioCreateDTOToUsuarioEntity(usuarioCreateDTO);
        UsuarioEntity saved = usuarioRepo.save(usuarioEntity);

        return usuarioMapper.UsuarioDTOToUsuarioEntity(saved);
    }
}
