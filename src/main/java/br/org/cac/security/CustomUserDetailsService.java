package br.org.cac.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.org.cac.models.User;
import br.org.cac.repositories.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
        
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(null == user){
			System.out.println("Usuário não encontrado: "+username);
			throw new UsernameNotFoundException("Usuário não encontrado: "+username);
		}else{
			List<String> userRoles = new ArrayList<String>();
			userRoles.add(user.getRole().name());
			return new CustomUserDetails(user,userRoles);
		}
	}
		
}
