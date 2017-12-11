package br.com.prog3.trabalho5pc3.CarolinaAtaide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudDisciplina {
	private static Map<Integer, Disciplina> mapaDisciplina = new HashMap<Integer, Disciplina>();

	public CrudDisciplina() {
		Disciplina d1 = new Disciplina();
		Disciplina d2 = new Disciplina();

		d1.setCargaHoraria(72);
		d1.setCodigo(1);
		d1.setDescricao("Programação de Computadores 1");

		d2.setCargaHoraria(72);
		d2.setCodigo(2);
		d2.setDescricao("Banco de Dados 1");

		mapaDisciplina.put(d1.getCodigo(), d1);
		mapaDisciplina.put(d2.getCodigo(), d2);
	}

	public List<Disciplina> listarTodos() {

		/*Collection cont = mapaDisciplina.values();
		Iterator i = cont.iterator();

		while (i.hasNext()) {
			Disciplina temp = (Disciplina)i.next();
			System.out.println(temp.toString());
		}*/

		List<Disciplina> lista = new ArrayList<>();
		for (Disciplina d : mapaDisciplina.values()) {
			System.out.println(d);
			lista.add(d);
		}
		return lista;
	}

	public Disciplina buscarPeloCodigo(Integer codigo) {
		if (mapaDisciplina.containsKey(codigo))
			return mapaDisciplina.get(codigo);
		else
			return null;
	}

	public void inserir(Disciplina d) {
		mapaDisciplina.put(d.getCodigo(), d);
	}

	public void excluir(Integer codigo) {
		if (mapaDisciplina.containsKey(codigo))
			mapaDisciplina.remove(codigo);
		else
			System.out.println("Codigo inexistente");
	}

	public void alterar(Disciplina d) {
		if (mapaDisciplina.containsKey(d.getCodigo()))
			mapaDisciplina.replace(d.getCodigo(), d);
		else {
			inserir(d);
			System.out.println("Disciplina Inserida");
		}
	}
}
