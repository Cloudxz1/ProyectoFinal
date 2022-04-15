package cl.icap.proyectofinal.m5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.icap.proyectofinal.m5.entity.Usuario;
import cl.icap.proyectofinal.m5.repository.UsuarioRepository;


 
@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuariosRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nombreusuario) throws UsernameNotFoundException {
		Usuario us = usuariosRepository.findByNombreusuario(nombreusuario);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("admin"));
		
		UserDetails userd = new User(us.getNombreusuario(), us.getPasswordusuario(), roles);
		
		return userd;
		}
	}