package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import entities.Task;

public class TaskService { // TODO -> finish this service
    private List<Task> listaTarefas; // Armazenamento de tarefas
    private Map<Integer, Task> mapaTarefas; // Busca por id
    private PriorityQueue<Task> filaPrioridade; // Fila de prioridade
    private Stack<Task> historico; // Histórico de tarefas concluídas

    public TaskService() {
        listaTarefas = new ArrayList<>();
        mapaTarefas = new HashMap<>();
        filaPrioridade = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getPriority().compareTo(t2.getPriority());
            }
        });
        historico = new Stack<>();
    }

    // Métodos para adicionar, buscar, remover e listar tarefas
}
