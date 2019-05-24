package br.org.cac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.cac.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
