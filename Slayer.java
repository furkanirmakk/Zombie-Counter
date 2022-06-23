/*BIL122 - Lab 6
 @furkanrmk Furkan IRMAK, <furkanirmak81@gmail.com>
*/
public class Slayer extends Thread{
    ZombieCounter zc;
    public Slayer(ZombieCounter zc){
      this.zc=zc;  
    }
    @Override
    public void run(){
        while(!zc.tooManyZombiesInTheRoom() && !zc.killed100Zombies()){
            
                zc.zombieKilled();
            
            try{
                Thread.sleep(2);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}