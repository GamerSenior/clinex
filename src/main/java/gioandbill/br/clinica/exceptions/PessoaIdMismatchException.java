package gioandbill.br.clinica.exceptions;

public class PessoaIdMismatchException extends RuntimeException {

    public PessoaIdMismatchException(String mensagem, Throwable cause){
        super(mensagem, cause);
    }

    public PessoaIdMismatchException(String mensagem){
        super(mensagem);
    }

    public PessoaIdMismatchException(Throwable cause){
        super(cause);
    }

    public PessoaIdMismatchException(){
        super();
    }
}
