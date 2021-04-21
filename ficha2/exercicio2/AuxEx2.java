public class AuxEx2 {
    // int[5][5] notasTurma
    // notasTurma [1][2] = nota do aluno 1 na Unidade Curricular 2

    /**
     * Le a nota de um aluno
     * @param aluno Aluno de que se quer saber a nota
     * @param uc UC à qual queremos saber a nota
     * @param notasTurma Matriz de alunos
     * @return Nota do aluno
     */
    public static int leNota(int aluno,int uc,int[][] notasTurma) {
        return notasTurma[aluno][uc];
    }

    /**
     * Atualiza uma matriz de alunos com uma nova nota
     * @param novaNota Nova nota a inserir
     * @param aluno Aluno que vai receber a nova nota
     * @param uc UC onde o aluno tirou a nova nota
     * @param notasTurma Matriz de alunos atualizada
     */
    public static void atualiza (int novaNota,int aluno,int uc, int[][] notasTurma) {
        notasTurma [aluno][uc] = novaNota;                     
    }

    /**
     * Soma as notas dos alunos a uma dada UC
     * @param uc UC onde se quer saber as notas
     * @param notasTurma Matriz de alunos
     * @return Soma das notas dos alunos
     */
    public static int somaNotasUC(int uc, int[][] notasTurma) {
        int r = 0;
        for (int i = 0; i < notasTurma.length; i++) 
                r+=notasTurma[i][uc];
        return r;
    }

    /**
     * Faz a média aritmética de um aluno
     * @param aluno Aluno que quer saber a média
     * @param notasTurma Matriz de alunos
     * @return Média do aluno
     */
    public static int mediaAluno(int aluno, int[][] notasTurma) {
        int notasAluno = 0;
        for (int j = 0; j< notasTurma.length;j++)
            notasAluno += notasTurma[aluno][j];
        return notasAluno/ notasTurma.length;
    }

    /**
     * Faz a média aritmética das notas atribuídas numa dada UC
     * @param uc UC onde se quer saber a média
     * @param notasTurma Matriz de alunos
     * @return Média das notas atribuídas
     */
    public static int mediaUC(int uc, int[][] notasTurma) {
        int notasUC = 0;
        for (int i = 0; i < notasTurma.length; i++)
            notasUC += notasTurma[i][uc];
        return notasUC / notasTurma.length;
    }

    /**
     * Calcula a maior nota obtida na turma a qualquer UC
     * @param notasTurma Matriz de alunos
     * @return Maior nota obtida
     */
    public static int notaMaisAlta(int[][] notasTurma) {
        int i,j,r;
        r = Integer.MIN_VALUE;//menor valor do array
        for (i = 0; i < notasTurma.length; i++){
            for (j = 0; j < notasTurma.length; j++){
                if (notasTurma[i][j] > r)
                    r = notasTurma [i][j];
            }
        }
        return r;
    }

    /**
     * Calcula a pior nota obtida na turma a qualquer UC
     * @param notasTurma Matriz de alunos
     * @return Pior nota obtida
     */
    public static int notaMaisBaixa(int[][] notasTurma) {
        int i,j,r;
        r = Integer.MAX_VALUE;//maior valor do array
        for (i = 0; i < notasTurma.length; i++) {
            for (j = 0; j < notasTurma.length; j++) {
                if (notasTurma[i][j] < r)
                    r = notasTurma[i][j];
            }
        }
        return r;
    }   

    /**
     * Retorna num array as notas que são acima a uma nota dada como argumento
     * @param nota Nota delimitadora
     * @param notasTurma Matriz de alunos
     * @return Array com as notas acima da nota inserida
     */
    public static int[] notasAcima(int nota, int[][] notasTurma) {
        int i,j,k = 0;
        int[] array = new int [5]; // basta alocar 6 bytes para o array final
        for (i = 0; i < notasTurma.length;i++){
            for (j = 0; j < notasTurma.length;j++){
                if (nota < notasTurma[i][j])
                    array[k] = notasTurma[i][j];
            k++;
            }
        }
        return array;
    }

    /**
     * Imprime a pauta de todos os alunos
     * @param notasTurma Matriz dos alunos
     */
    public static void pauta(int[][] notasTurma) {
        int i,j;
        for (i = 0; i < notasTurma.length; i++) {
            for (j = 0; j < notasTurma.length; j++) {
                System.out.println("Aluno: "+i+" -> "+"Nota à UC "+j+":"+notasTurma[i][j]);
            }
        } 
    }

    /**
     * Calcula a UC com a melhor média de aprovados
     * @param notasTurma Matriz de alunos
     * @return UC com a melhor média de aprovados
     */
    public static int melhorUC(int[][] notasTurma) {
        int i, j;
        int bestUC = mediaUC(Integer.MIN_VALUE, notasTurma); //pior media possivel
        for (i = 0; i < notasTurma.length; i++) {
            for (j = 0; j < notasTurma.length; j++) {
                if (bestUC < mediaUC(j, notasTurma))
                    bestUC = mediaUC(j, notasTurma);
            }
        }
        return bestUC;
    }
}


