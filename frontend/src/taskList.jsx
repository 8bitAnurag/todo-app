import { useState } from "react";

export default function TaskList() {
  const [isFormOpen, setIsFormOpen] = useState(false);

  const [tasks, setTasks] = useState([
    { id: 1, title: "Do homework", completed: false },
    { id: 2, title: "Buy milk", completed: true },
    { id: 3, title: "Clean room", completed: false },
  ]);

  const [newTitle, setNewTitle] = useState("");
  const [newDeadline, setNewDeadline] = useState("");
  const [newReminder, setNewReminder] = useState("");

  return (
    <div>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <input
              type="checkbox"
              checked={task.completed}
              onChange={() => {
                setTasks(
                  tasks.map((t) =>
                    t.id === task.id ? { ...t, completed: !t.completed } : t
                  )
                );
              }}
            />
            <span
              style={{
                textDecoration: task.completed ? "line-through" : "none",
              }}
            >
              {task.title}
            </span>
          </li>
        ))}
      </ul>

      <button onClick={() => setIsFormOpen(true)}>+</button>

      {isFormOpen && (
        <div>
          <h2>New Task</h2>
          <form>
            <div>
              <label>
                Title:
                <input
                  type="text"
                  value={newTitle}
                  onChange={(e) => setNewTitle(e.target.value)}
                />
              </label>
            </div>

            <div>
              <label>
                Deadline:
                <input
                  type="date"
                  value={newDeadline}
                  onChange={(e) => setNewDeadline(e.target.value)}
                />
              </label>
            </div>

            <div>
              <label>
                Reminder:
                <input
                  type="datetime-local"
                  value={newReminder}
                  onChange={(e) => setNewReminder(e.target.value)}
                />
              </label>
            </div>

            <button type="button" onClick={() => setIsFormOpen(false)}>
              Cancel
            </button>
            <button
              type="button"
              onClick={() => {
                if (!newTitle.trim()) return;

                const newTask = {
                  id: Date.now(),
                  title: newTitle,
                  completed: false,
                  deadline: newDeadline,
                  reminder: newReminder,
                };

                setTasks([...tasks, newTask]);
                setIsFormOpen(false);
                setNewTitle("");
                setNewDeadline("");
                setNewReminder("");
              }}
            >
              Save
            </button>
          </form>
        </div>
      )}
    </div>
  );
}
