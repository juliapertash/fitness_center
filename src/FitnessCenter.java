public class FitnessCenter {
   private  String adress;
    private int price;
   private String dates;

    public FitnessCenter(String a, int b, String c)
    {
        adress = a;
        price = b;
        dates = c;
    }

    public String GetAd()
            {
                return adress;
            }
    public String GetPr()
    {
        return Integer.toString(price);
    }

 public String GEtDates() {return dates;}


}
