package br.uff.ic.poo.ex1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Luam */

public class CadastroCliente {
    public static void inserirCliente(Cliente novo) throws RepositorioException, ClienteJaExistenteException {
        if (buscarCPF(novo)){
         throw new ClienteJaExistenteException();  
        }
         else if (ClienteArquivo.contador<10){
            ClienteArquivo.inserir(novo);
        }
        else{
            throw new RepositorioException();
        }
    }
    
    
    public static ArrayList<Cliente> buscarClienteNome(String nome){
        try {
            return ClienteArquivo.buscarPorNome(nome);
        } catch (ClienteInexistenteException ex) {
           ex.getMessage();
        }    
        return null;
    }
    
    public static boolean buscarCPF(Cliente c) {
        Cliente aux = null;
        try {
            aux = ClienteArquivo.buscarPorCPF(c.getCpf());
        } catch (ClienteInexistenteException ex) {
            ex.getMessage();
        }
        return aux.cpf.isEmpty();
    }

  
}
