public class InteligenciaCentral {
    @Getter
    @Setter
    private List<Rebelde> rebeldes = new LinkedList<Rebelde>();

    public static void solicitarIngresso(Rebelde rebelde) {
        if(!buscarRebelde(arrayRebeldes, rebelde))
            Utils.add(arrayRebeldes, rebelde);
        else
            System.out.println("Esse rebelde já está na lista.");
    }

    public static boolean buscarRebelde(Rebelde[] arr, Rebelde rebelde){
        return Arrays.asList(arr).contains(rebelde);
    }
}
