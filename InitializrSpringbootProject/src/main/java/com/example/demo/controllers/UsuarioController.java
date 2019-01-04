/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import org.bson.types.ObjectId;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Usuario get(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") ObjectId id, @Valid
            @RequestBody Usuario usuario) {
        usuario.set_id(id);
        repository.save(usuario);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Usuario create(@Valid @RequestBody Usuario usuario) {
        usuario.set_id(ObjectId.get());
        repository.save(usuario);
        return usuario;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}
