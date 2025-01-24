//Interfaz que define las operaciones basicas de la licuadora.
public interface IBlender{
    //incrementar velocidad
    void SpeedUp();
    //reducir velocidad 
    void SpeedDown();
    //llenar licuadora
    void Fill();
    // vaciar licuadora
    void Empty();
    /*
    Verifica si la licuadora está llena.
    return true si la licuadora está llena, false en caso contrario.
     */
    boolean IsFull();
    // devuelve la velocidad actual de la licuadora
    int GetSpeed();
}
