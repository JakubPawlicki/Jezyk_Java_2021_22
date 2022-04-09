Podczas kolokwium utwórz: 
1. Pakiet pl.edu.uj.sender;
2. interface Sender z metodą void send(Message message, Recipient recipient) throws SenderException
3. SenderException dziedziczy po Exception 
4. Klasę Message z metodami abstrakcyjnymi: 
  * String getMessageTitle()
  * String getMessageBody()
5. Klasę Recipient z metodą abstrakcyjną String getRecipientAddress()
6. 2 klasy implementują 1. interface Sender :  
  * EmailSender
    * pisze do System.out wiadomość: “[Email] Messege sent, title=..., bodyMD5=...(md5 z wiadomości), recipent=***@abc.com (początek adresu zamazany)”
    * rzuca błędami, gdy:
      * message, recipient nie są odpowiedniego typu lub są null
      * MessageTitle, MessageBody są puste
      * RecipientAddress nie jest poprawnym adresem email (przynajmniej …@...)
  * PushSender
    * pisze do System.out wiadomość: “[Push] Messege sent, title=..., bodyMD5=...(md5 z wiadomości), recipent=***... (początek adresu zamazany, ostatnie 5 znaków)”
    * rzuca błędami, gdy:
      * message, recipient nie są odpowiedniego typu lub są null
      * MessageTitle, MessageBody są puste
      * MessageBody dłuższe niż 256 znaków
      * RecipientAddress nie jest stringiem 32 znakow A-Za-z0-9
