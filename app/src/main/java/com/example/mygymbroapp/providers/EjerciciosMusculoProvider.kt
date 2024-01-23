package com.example.mygymbroapp.providers

import com.example.mygymbroapp.clasesMusculos.EjerciciosMusculo

class EjerciciosMusculoProvider {
    companion object{
        //Pectoral.
        val pectoralSuperiorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Press banca inclinado", "https://eresfitness.com/wp-content/uploads/Press-de-banca-inclinado-con-barra.webp"),
            EjerciciosMusculo("Press banca inclinado con mancuernas", "https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/press-pectoral-con-mancuernas-en-banco-inclinado-init-pos-8206.png"),
            EjerciciosMusculo("Flexiones piernas elevadas", "https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/flexiones-de-brazos-con-piernas-apoyadas-sobre-banco-init-pos-5610.png"),
        )

        val pectoralMayorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Press banca plano", "https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/press-de-banca-con-barra-init-pos-3832.png"),
            EjerciciosMusculo("Press banca plano con mancuernas", "https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/press-banca-con-mancuernas-agarre-neutro-init-pos-3115.png"),
            EjerciciosMusculo("Flexiones convencionales", "https://www.mundodeportivo.com/files/content_image_mobile_filter/uploads/2022/10/03/633ace4454f1d.jpeg")
        )

        val pectoralInferiorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Fondos", "https://i0.wp.com/streetliftingacademy.com/wp-content/uploads/2023/04/tecnica-de-fondos-para-pecho.jpg?fit=819%2C1024&ssl=1"),
            EjerciciosMusculo("Fondos con barra", "https://i.blogs.es/0ee184/1366_2000/1366_2000.jpeg")
        )

        val pectoralSuperiorInteriorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Cruce de poleas baja", "https://4.bp.blogspot.com/-bhu23f_iArk/Ubc2xIJaqoI/AAAAAAAACdY/-ENxl5VwT1s/s1600/cover.jpg")
        )

        val pectoralMayorInteriorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Cruce de poleas alta", "https://www.cambiatufisico.com/wp-content/uploads/cruces-polea-alta.jpg")
        )

        val pectoralInferiorInteriorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Press cable lc", "https://s3assets.skimble.com/assets/1270913/image_iphone.jpg")
        )
/*
        //Deltoides.
        val deltoidesAnteriorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Press hacia afuera", "https://i.pinimg.com/564x/19/65/d9/1965d95b756827d741f1021a79dde674.jpg"),
            EjerciciosMusculo("", ""),
            EjerciciosMusculo("", ""),
            EjerciciosMusculo("", "")
        )

        val deltoidesMedioList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Elevación lateral con trampa", "https://i.ytimg.com/vi/De71cTpPKjc/sddefault.jpg"),
            EjerciciosMusculo("Press Arnold", "https://mundoentrenamiento.com/wp-content/uploads/2021/08/press-arnold.jpeg"),
            EjerciciosMusculo("", ""),
            EjerciciosMusculo("", "")
        )

        val deltoidesPosteriorList = listOf<EjerciciosMusculo>(
            EjerciciosMusculo("Fly en reversa", "https://weighttraining.guide/wp-content/uploads/2016/05/Dumbbell-Rear-Lateral-Raise-resized.png"),
            EjerciciosMusculo("", ""),
            EjerciciosMusculo("", ""),
            EjerciciosMusculo("", "")
        )

 */
    }
}