package gioandbill.br.clinica.exceptions;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(String mensagem, Throwable cause){
        super(mensagem, cause);
    }
    
    public PessoaNotFoundException(String mensagem){
        super(mensagem);
    }

    public PessoaNotFoundException(Throwable cause){
        super(cause);
    }

    public PessoaNotFoundException(){
        super();
    }
}
