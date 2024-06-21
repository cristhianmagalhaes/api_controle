package com.cantinhodoparque.api_controle.responsavel;

import com.cantinhodoparque.api_controle.endereco.DadosEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroResponsavel(
		
		@NotBlank
		String nome,
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		String telefone,
		
		@NotNull
		Parentesco parentesco,
		
		@NotNull
		@Valid
		DadosEndereco endereco
		
		) {

}
