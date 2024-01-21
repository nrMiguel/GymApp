package com.example.mygymbroapp.providers

import com.example.mygymbroapp.placeholder.GrupoMuscular

class GrupoMuscularProvider {
    companion object{
        val grupoMuscularList = listOf<GrupoMuscular>(
            GrupoMuscular("Pecho", "https://bulevip.com/blog/wp-content/uploads/2015/11/pectoral-mayor-musculos.jpg"),
            GrupoMuscular("Deltoides", "https://blog.yamamotonutrition.com/static/embed/anatomia-muscolo-deltoide-spalla-es.jpg"),
            GrupoMuscular("Biceps", "https://www.shoulder-pain-explained.com/images/biceps-stretch-exercises.jpg"),
            GrupoMuscular("Braquial", ""),
            GrupoMuscular("Bracoradial", "https://fisioterapiaintuitiva.files.wordpress.com/2016/06/braquioradiale.jpg"),
            GrupoMuscular("Antebrazos", "https://previews.123rf.com/images/decade3d/decade3d1307/decade3d130700106/20869752-antebrazos-anatom%C3%ADa-m%C3%BAsculos.jpg"),
            GrupoMuscular("Trapecios", "https://i.ytimg.com/vi/G3ZgZxTK0es/maxresdefault.jpg"),
            GrupoMuscular("Triceps", "https://images.hola.com/imagenes/estar-bien/20210311185849/ejercicios-triceps-fortalecer-brazos/0-929-371/ejercicios-triceps5-a.jpg"),
            GrupoMuscular("Espalda", "https://i.pinimg.com/736x/26/3d/d9/263dd97602d571593f96fc588b6ffa6a.jpg"),
            GrupoMuscular("Gluteos", "https://somasalud.es/wp-content/uploads/2019/03/musculo-gluteo-1536x864.jpg"),
            GrupoMuscular("Piernas", "https://findyoureverest.es/wp-content/uploads/2020/04/musculos-de-la-pierna-1024x768.jpg")
        )
    }
}