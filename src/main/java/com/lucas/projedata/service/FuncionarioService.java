package com.lucas.projedata.service;

import com.lucas.projedata.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class FuncionarioService {

    public List<Funcionario> criarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18),
                new BigDecimal("2000.00"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"), "Gerente"));

        return funcionarios;
    }

    public void removerJoao(List<Funcionario> lista) {
        lista.removeIf(f -> f.getNome().equalsIgnoreCase("João"));
    }

    public void aumentarSalario(List<Funcionario> lista) {

        BigDecimal percentual = new BigDecimal("0.10");

        for (Funcionario f : lista) {
            BigDecimal aumento = f.getSalario().multiply(percentual);
            BigDecimal novoSalario = f.getSalario().add(aumento);

            f.setSalario(novoSalario);
        }
    }

    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> lista) {
        Map<String, List<Funcionario>> agrupados = new TreeMap<>();

        for (Funcionario f : lista) {
            agrupados.computeIfAbsent(f.getFuncao(), k -> new ArrayList<>()).add(f);
        }

        return agrupados;
    }

    public List<Funcionario> filtrarAniversariantes(List<Funcionario> lista) {
        return lista.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .toList();
    }

    public Funcionario encontrarMaisVelho(List<Funcionario> lista) {

        Funcionario maisVelho = lista.get(0);

        for (Funcionario f : lista) {
            if(f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }

        return maisVelho;
    }

    public int calcularIdade(Funcionario f) {
        return Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
    }

}
