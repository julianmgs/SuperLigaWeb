package com.julian.superliga.service.inter;

import java.io.IOException;

import com.julian.superliga.vo.Mensaje;

public interface EmailService {

	void sendEmailContacto(Mensaje mensaje) throws IOException;

}
