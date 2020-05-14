**Shared Preferences Kullanımı**

Eğer uygulama içerisinde ufak verilerin kayıtlı kalması isteniyorsa ve en önemlisi bu verilerin uygulama kapandığında kaybolması istenmiyorsa "SharedPreferences" işe yarar olan, HashMap yapısına(key-value) benzeyen bir yapıdır. Ufak veriler için database kullanmak pek mantıklı değildir. Aynı şekilde büyük veriler için de sharedpreferences kullanmak mantıklı değildir. Sharedpreference içinde primitive(string,int,boolean,float,long) data tipinde veriler tutulabilir ve bu veriler uygulama kapansada kaybolmaz.
