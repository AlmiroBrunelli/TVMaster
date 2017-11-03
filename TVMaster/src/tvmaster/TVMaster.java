package tvmaster;

import java.text.DecimalFormat;
import java.util.ArrayList;
import model.Canal;
/*import model.Categoria;
import model.Chamado;
import model.Cliente;
import model.Contrato;
import model.Ilimitado;
import model.Regular;
import model.Top;*/
import javax.swing.UIManager;
import view.TelaLogin;

public class TVMaster {

    public static void main(String[] args) {
        String tema_padrao = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {  
              UIManager.setLookAndFeel(tema_padrao);  
            } catch (Exception e) {  
        }
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
        /*
        // DECLARAÇÃO DOS CANAIS
       
        ArrayList<Canal> canaisNoticia = new ArrayList<Canal>();
        Canal canal1N = new Canal("Globo News", 5f, 40);
        Canal canal2N = new Canal("Band News", 7.50f, 30);
        Canal canal3N = new Canal("Record News", 5f, 42);
        
        canaisNoticia.add(canal1N);
        canaisNoticia.add(canal2N);
        canaisNoticia.add(canal3N);
        
        ArrayList<Canal> canaisFilme = new ArrayList<Canal>();
        Canal canal1F = new Canal("Telecine Premium", 8f, 60);
        Canal canal2F = new Canal("Telecine Pipoca", 8.50f, 61);
        Canal canal3F = new Canal("HBO Plus", 9f, 62);
        
        canaisFilme.add(canal1F);
        canaisFilme.add(canal2F);
        canaisFilme.add(canal3F);

        ArrayList<Canal> canaisDesenho = new ArrayList<Canal>();
        Canal canal1D = new Canal("Cartoon Network", 4.90f, 90);
        Canal canal2D = new Canal("Boomerang", 5.50f, 91);
        Canal canal3D = new Canal("Nickelodeon", 4.70f, 92);
        
        canaisDesenho.add(canal1D);
        canaisDesenho.add(canal2D);
        canaisDesenho.add(canal3D);
        
        ArrayList<Canal> canaisInternacional = new ArrayList<Canal>();
        Canal canal1I = new Canal("WooHoo", 7.80f, 70);
        Canal canal2I = new Canal("Bloomberg", 6.75f, 71);
        Canal canal3I = new Canal("Discovery Science", 7.80f, 72);
        
        canaisInternacional.add(canal1I);
        canaisInternacional.add(canal2I);
        canaisInternacional.add(canal3I);
        
        // DECLARAÇÃO DAS CATEGORIAS
        
        System.out.println("TESTE DO PLANO ILIMITADO");
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        Categoria cat1 = new Categoria("Notícias", canaisNoticia);
        Categoria cat2 = new Categoria("Filmes", canaisFilme);
        Categoria cat3 = new Categoria("Desenhos", canaisDesenho);
        Categoria cat4 = new Categoria("Internacional", canaisInternacional);
        categorias.add(cat1);
        categorias.add(cat2);
        categorias.add(cat3);
        categorias.add(cat4);
        
        // TESTE DO PLANO ILIMITADO
        
        Ilimitado i = new Ilimitado(categorias, 0.10f);
        
        // teste de impressão das categorias do plano ilimitado
        System.out.println("Preço: R$" + format(i.getPreco()));
        for(Categoria categoria : categorias){
            System.out.println("Nome da categoria: " + categoria.getNome());
        }

        // TESTE DO PLANO REGULAR
        System.out.println("TESTE DO PLANO REGULAR");
        
        ArrayList<Categoria> categoriasRegular = new ArrayList<Categoria>();
        Categoria catR1 = new Categoria("Notícias", canaisNoticia);
        Categoria catR2 = new Categoria("Filmes", canaisFilme);
        Categoria catR3 = new Categoria("Desenhos", canaisDesenho);
        categoriasRegular.add(catR1);
        categoriasRegular.add(catR2);
        categoriasRegular.add(catR3);
        Regular regular = new Regular(categoriasRegular, 0.15f);
        
        // teste de impressão das categorias do plano regular
        System.out.println("Preço: R$" + format(regular.getPreco()));
        for(Categoria categoria : regular.getCategorias()){
            System.out.println("Nome da categoria: " + categoria.getNome());
        }
        
        // teste de remoção de categoria do plano regular
        regular.removerCategoria(catR1);
        System.out.println("Preço: R$" + format(regular.getPreco()));
        for(Categoria categoria : regular.getCategorias()){
            System.out.println("Nome da categoria: " + categoria.getNome());
        }
        
        // teste de adição de nova categoria após remoção
        Categoria catR4 = new Categoria("Internacional", canaisInternacional);
        regular.adicionarCategoria(catR4);
        System.out.println("Preço: R$" + format(regular.getPreco()));
        for(Categoria categoria : regular.getCategorias()){
            System.out.println("Nome da categoria: " + categoria.getNome());
        }
        
        // teste de adição de categoria quando exceder o limite de categorias
        regular.adicionarCategoria(catR1);
        System.out.println("Preço: R$" + format(regular.getPreco()));
        for(Categoria categoria : regular.getCategorias()){
            System.out.println("Nome da categoria: " + categoria.getNome());
        }
        
        // TESTE DO PLANO TOP
        
        System.out.println("TESTE DO PLANO TOP");
        
        ArrayList<Canal> canaisTop = new ArrayList<Canal>();
        
        canaisTop.add(canal1N);
        canaisTop.add(canal2N);
        canaisTop.add(canal1F);
        canaisTop.add(canal3F);
        canaisTop.add(canal1D);
        canaisTop.add(canal2D);
        canaisTop.add(canal3D);
        
        Top top = new Top(canaisTop);
        
        System.out.println("Preço: " + format(top.getPreco()));
        
        // teste de adição de canal ao plano top
        System.out.println("Teste de adição de canal ao plano top");
        top.adicionarCanal(canal3I);
        System.out.println("Preço: " + format(top.getPreco()));
        
        // teste de remoção de canal ao plano top
        System.out.println("Teste de remoção de canal do plano top");
        top.removerCanal(canal1N);
        System.out.println("Preço: " + format(top.getPreco()));
        
        System.out.println("Lista de canais do plano Top:");
        for(Canal atual : top.getCanais()) {
            System.out.println("Nome: " + atual.getNome() + " Preço: R$" + 
                    format(atual.getPreco()) + " Canal: " + atual.getNumero());
        }
        
        System.out.println("TESTE DO FOR");
        Canal canalt = pegarCanal("Band News", canaisTop);
        canalt.setNome("Globo");
        
        System.out.println("Lista modificada de canais do plano Top:");
        for(Canal atual : top.getCanais()) {
            System.out.println("Nome: " + atual.getNome() + " Preço: R$" + 
                    format(atual.getPreco()) + " Canal: " + atual.getNumero());
        }
        
        Contrato contrato = new Contrato(1, 1, "Rua A, N57", 0, "Salvador", top);
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        contratos.add(contrato);
        
        Cliente cliente = new Cliente("Fulano de Tal", "fulano@email.com", 999999, 33333333, contratos);
        
        Contrato contratoPesquisado = cliente.pesquisarContrato(1);
        contratoPesquisado.adicionarReceptor(2);
        contratoPesquisado.criarFatura("Janeiro");
        contratoPesquisado.criarChamado("Sinal ruim", 25042017, 2017001, false, cliente);
        contratoPesquisado.verificarInadimplencia();
        
        System.out.println("Impressão Contratos");
        for(Contrato atual : cliente.getContratos()) {
            System.out.println("Numero: " + atual.getNumero());
            System.out.println("Endereço: " + atual.getEndereco());
            System.out.println("Estado: " + atual.getEstado());
            System.out.println("Receptores: " + atual.getReceptores());
            System.out.println("Chamados do contrato:");
            for(Chamado catual : atual.getChamados()) {
                System.out.println("Motivo: " + catual.getMotivo());
                System.out.println("Data: " + catual.getData());
                System.out.println("Situação: " + catual.isSituacao());
            }
        }
        
    }*/
    public static String format(double x) {  
        DecimalFormat df = new DecimalFormat("#0.00");  
        return df.format(x);
    }
    
    public static Canal pegarCanal(String nome, ArrayList<Canal> c) {
        Canal teste = new Canal("Teste", 10f, 24);
        for(Canal canal : c) {
            if(canal.getNome().equals(nome)) {
                return canal;
            }
            
        }
        return teste;    
    }

}
