public class AuxEx3 { //corrigir
    public class ListaDeLocalDates()
    {
        private LocalDate datas[];
        private int tamanho;

        public ListaDeLocalDates() {
            this(10);
        }

        public ListaDeLocalDates(int n) {
            this.datas = new LocalDate[n];
            this.tam = 0;
        }

        public void insereData(LocalDate data) {
            if (tam < datas.length)
                this.datas[tam++] = data;
        }
    }
}
