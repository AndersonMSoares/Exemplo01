package br.utfpr.tdd.ex1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreendo
 */
public class Aluno {
    
    private List<Double> notasAtividadesPraticas = new ArrayList<>();
    private double notaProjeto;
    private double notaRAA = -1;
    private int faltas;
    private String ra; 
    private String nome;
    
    public Aluno(String ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    public void addNotaAtividadePratica(double nota) {
        notasAtividadesPraticas.add(nota);
    }

    public double getNAP() {
        if(notasAtividadesPraticas.isEmpty())
            return 0.0;
        
        double nap = 0; 
        for (Double nota : notasAtividadesPraticas) {
            nap += nota;
        }
        
        return nap / notasAtividadesPraticas.size();
    }

    void setNotaProjeto(double nota) {
        notaProjeto = nota;
    }

    double getNF() {
        if(notaRAA < 0){
            double a = (notaProjeto + getNAP()) / 2.0;
            if( a <= 6.0 && a > 5.95 ){
            return 6.0;
            }
            return a;
        }
        double a = (notaProjeto + getNAP() + notaRAA) / 3.0;
        if(a > 5.95)
            return 6.0;
        return a;
    }

    void setNotaRAA(double nota) {
        notaRAA = nota;
    }

    void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    int getFaltas() {
        return faltas;
    }

    public String getRA() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroAtividadesPraticas() {
        return notasAtividadesPraticas.size();
    }

    public double getNotaProjeto() {
        return notaProjeto;
    }

    public double getNotaRAA() {
        return notaRAA;
    }
    
}
