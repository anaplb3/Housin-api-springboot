package com.dcx.pas.housinapi.controller;

import com.dcx.pas.housinapi.service.UserService;
import com.dcx.pas.housinapi.model.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @ApiResponse(code = 200, message = "Retorna os usuários cadastrados")
    @ApiOperation(value = "Retorna os usuários cadastrados no sistema", response = Iterable.class, produces = "application/json")
    @GetMapping("v1/api/usuarios")
    @ResponseStatus( HttpStatus.OK )
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK );
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário encontrado"),
            @ApiResponse(code = 404, message = "Usuário não encontrado")
    })
    @ApiOperation(value = "Retorna um usuario especifíco", response = User.class, produces = "application/json")
    @GetMapping("v1/api/usuarios/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") int id) {
        User user = userService.getUser(id);

        if (user != null) return new ResponseEntity<>(user, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Cria um novo usuario", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "Usuário criado com sucesso"),
            @ApiResponse( code = 400, message = "Não foi possível criar usuário")
    })
    @PostMapping("v1/api/usuarios")
    public ResponseEntity<?> postUser(@RequestBody User user) {
        if (userService.createUser(user)) return new ResponseEntity<>(HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Não foi possível deletar o usuário"),
            @ApiResponse(code = 410, message = "Usuário deletado com sucesso")
    })
    @ApiOperation(value = "Deleta um usuário baseado no ID passado")
    @DeleteMapping("v1/api/usuarios/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>(HttpStatus.GONE);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Atualiza os dados de um usuário", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "Usuário criado com sucesso"),
            @ApiResponse( code = 400, message = "Não foi possível criar usuário")
    })
    @PutMapping("v1/api/usuarios/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") int id, @RequestBody User user) {
        if(userService.updateUser(user)) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
