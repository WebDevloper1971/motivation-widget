import express from "express";
import data from "./data.js";

const port = 3000;
const app = express();

app.get("/:id", (req, res) => {
  const id = parseInt(req.params.id);
  if (id > 31 || id < 0) {
    res.send(`<h2 style="color:red;">Index out of bounds</h2>`);
  } else {
    res.json(data[id]);
  }
});

app.listen(port, () => {
  console.log(`Server started at ${port}`);
});
