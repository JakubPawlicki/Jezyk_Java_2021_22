public class SubtitlesLineMalformedException extends Exception {

    public SubtitlesLineMalformedException(String errorMessage){super(errorMessage);}
    public SubtitlesLineMalformedException(String errorMessage, Exception e){
      super(errorMessage, e);
  }

}
