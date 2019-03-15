class Aerobics extends FitnessCenter
        {
        private String uprazneniya;

        public Aerobics(String a, int b, String c, String d)
        {
        super(a, b, c);
        uprazneniya=d;

        }
        public String ToString()
        {
        return "Упражнения - "+uprazneniya+", Адрес - "+GetAd()+" Цена - "+GetPr()+", даты - "+GEtDates();
        }
        }
