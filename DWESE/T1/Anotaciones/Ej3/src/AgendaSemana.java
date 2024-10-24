import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TareaAn (
        titulo = "Estudiar",
        descripcion = "Temas 1, 2 y 3 de Cliente",
        dia = 6,
        hora = 13.15
) @TareaAn (
        titulo = "Entrenar",
        descripcion = "Natación",
        dia = 1,
        hora = 20.00
) @TareaAn (
        titulo = "Entrenar",
        descripcion = "Gimnasio",
        dia = 4,
        hora = 19.30
) @TareaAn (
        titulo = "Coche",
        descripcion = "Echar gasolina y lavar el coche",
        dia = 6,
        hora = 11.30
)
@TareaAn (
        titulo = "Clase",
        descripcion = "Religión a primera",
        dia = 0,
        hora = 9.15
)
public class AgendaSemana {
    private List<Tarea> agenda;

    public AgendaSemana() {
        agenda = new ArrayList<Tarea>();
    }

    public boolean addTarea(Tarea t) {
        boolean added = agenda.add(t);
        Collections.sort(agenda);

        return added;
    }

    public boolean removeTarea(Tarea t) {
        return agenda.remove(t);
    }

    public static AgendaSemana cargadorDeContexto () {
        AgendaSemana agenda = new AgendaSemana();
        TareaAn[] tareas = AgendaSemana.class.getAnnotationsByType(TareaAn.class);

        for (TareaAn t : tareas) {
            agenda.addTarea(new Tarea(t.titulo(), t.descripcion(), t.dia(), t.hora()));
        }
        return agenda;
    }

    @Override
    public String toString() {
        String res = "\t--AGENDA--";
        int counter = 1;

        for (Tarea t : agenda) {
            res += "\n\n- Tarea " + counter++ + "\n" + t;
        }
        return res;
    }
}
