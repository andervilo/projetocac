package br.org.cac;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import br.org.cac.models.Doacao;
import br.org.cac.repositories.DoacaoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
	
	@Autowired
	DoacaoRepository doacaoRepository;

	@Test
	public void contextLoads() throws ParseException {
		Pageable pageable = PageRequest.of(0, 5, new Sort(Direction.DESC, "id"));
		Page<Doacao> result =  doacaoRepository.findByColaboradorNomeContainingOrCadastro(
				"", 
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-15"), 
				pageable);
		
		List<Doacao> result2 = doacaoRepository.findByCadastro(
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-15"));
		
		Page<Doacao> result3 = doacaoRepository.findByCadastro(
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-15"), pageable);
		
		Page<Doacao> result4 =  doacaoRepository.findByColaboradorNomeContainingOrCadastro(
				null, 
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-15"), 
				pageable);
		
		Page<Doacao> result5 =  doacaoRepository.findByColaboradorNomeContainingAndCadastroBetween(
				"", 
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-15"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-15"), 
				pageable);
		
		assertEquals(1, result5.getContent().size());
	}

}
