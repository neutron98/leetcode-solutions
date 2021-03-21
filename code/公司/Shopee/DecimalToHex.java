class DecimalToHex{

    public static void convert(int decimal){

      String hex = "";

      while(decimal != 0){
        int hexValue = decimal%16;
        char hexDigit;
          
        if (hexValue <= 9 && hexValue >= 0){
            hexDigit = (char)(hexValue +'0');
        } else{
            hexDigit = (char)(hexValue -10 + 'A' );
        }

        hex = hexDigit + hex;
        decimal = decimal / 16;
      }
      return hex;
    }
}
