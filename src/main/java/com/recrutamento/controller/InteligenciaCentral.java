public class InteligenciaCentral {
    @Getter
    @Setter
    private List<Rebelde> rebeldes = new LinkedList<Rebelde>();

    public void add(Rebelde rebelde){
        if (solicitarIngresso(rebelde))  {
            this.rebeldes.add(rebelde);
        }
    }

    /*public static void solicitarIngresso(Rebelde rebelde) {
        if(!buscarRebelde(arrayRebeldes, rebelde))
            Utils.add(arrayRebeldes, rebelde);
        else
            System.out.println("Esse rebelde já está na lista.");
    }*/

    public void imprimirAprovados(){
        try {
            @Cleanup PrintWriter writer = new PrintWriter("lista-rebeldes-aprovados.txt", "UTF-8");
            PrintWriter finalWriter = writer;
            this.getRebeldesAprovados().stream().forEach(x -> {
                finalWriter.println(x.toString());
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private boolean solicitarIngresso(Rebelde rebelde){
        String[] possiveisRespostas = {"Apto","Inapto"};
        int resultado = new Random().nextInt(2);
        if (possiveisRespostas[resultado] == "Apto") {
            System.out.println("Rebelde aprovado!");
            return true;
        } else {
            System.out.println("Rebelde reprovado!");
            return false;
        }
    }

    public static boolean buscarRebelde(Rebelde[] arr, Rebelde rebelde){
        return Arrays.asList(arr).contains(rebelde);
    }

    public static void comparaRebeldes(int[] arr1, int[] arr2) {
        Arrays.compare(arr1, arr2);
    }

    public static Rebelde[] copiarLista() {
        Rebelde[] rebelde = Arrays.copyOf(arrayRebeldes, 12);

        return rebelde;
    }
}
