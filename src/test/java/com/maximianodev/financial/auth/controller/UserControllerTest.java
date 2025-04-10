package com.maximianodev.financial.auth.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maximianodev.financial.auth.dto.RegisterRequestDTO;
import com.maximianodev.financial.auth.dto.AuthRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
  private final MockMvc mockMvc;
  private final ObjectMapper objectMapper;

  @Autowired
  public UserControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
    this.mockMvc = mockMvc;
    this.objectMapper = objectMapper;
  }

  @Test
  void shouldReturnBadRequestForInvalidEmail() throws Exception {
    RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
    registerRequestDTO.setEmail("invalid-email");
    registerRequestDTO.setName("Test");
    registerRequestDTO.setPassword("Test@123");
    String user = objectMapper.writeValueAsString(registerRequestDTO);

    mockMvc
        .perform(post("/api/users/register").contentType("application/json").content(user))
        .andExpect(status().isBadRequest());
  }

  @Test
  void shouldReturnBadRequestForEmptyName() throws Exception {
    RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
    registerRequestDTO.setEmail("test@test.com");
    registerRequestDTO.setName("");
    registerRequestDTO.setPassword("Test@123");
    String user = objectMapper.writeValueAsString(registerRequestDTO);

    mockMvc
        .perform(post("/api/users/register").contentType("application/json").content(user))
        .andExpect(status().isBadRequest());
  }

  @Test
  void shouldReturnBadRequestForWeakPassword() throws Exception {
    RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
    registerRequestDTO.setEmail("test@test.com");
    registerRequestDTO.setName("Test");
    registerRequestDTO.setPassword("123");
    String user = objectMapper.writeValueAsString(registerRequestDTO);

    mockMvc
        .perform(post("/api/users/register").contentType("application/json").content(user))
        .andExpect(status().isBadRequest());
  }

  @Test
  void shouldReturnBadRequestForInvalidLoginEmail() throws Exception {
    AuthRequestDTO authRequestDTO = new AuthRequestDTO();
    authRequestDTO.setEmail("invalid-email");
    authRequestDTO.setPassword("Test@123");
    String userLogin = objectMapper.writeValueAsString(authRequestDTO);

    mockMvc
        .perform(post("/api/users/login").contentType("application/json").content(userLogin))
        .andExpect(status().isBadRequest());
  }

  @Test
  void shouldReturnBadRequestForEmptyPassword() throws Exception {
    AuthRequestDTO authRequestDTO = new AuthRequestDTO();
    authRequestDTO.setEmail("test@test.com");
    authRequestDTO.setPassword("");
    String userLogin = objectMapper.writeValueAsString(authRequestDTO);

    mockMvc
        .perform(post("/api/users/login").contentType("application/json").content(userLogin))
        .andExpect(status().isBadRequest());
  }

  @Test
  void shouldReturnBadRequestForEmptyEmail() throws Exception {
    AuthRequestDTO authRequestDTO = new AuthRequestDTO();
    authRequestDTO.setEmail("");
    authRequestDTO.setPassword("Test@123");
    String userLogin = objectMapper.writeValueAsString(authRequestDTO);

    mockMvc
        .perform(post("/api/users/login").contentType("application/json").content(userLogin))
        .andExpect(status().isBadRequest());
  }
}
