import { useEffect, useRef, useState } from "react";
import axios from "axios";
import "./Search.css";
import "./Search.css";
export default function Search() {
  const [query, setQuery] = useState("");
  const [books, setBooks] = useState([]);
  const [show, setShow] = useState(false);

  useEffect(() => {
    if (query.trim() === "") {
      setBooks([]);
      return;
    }

    const timeout = setTimeout(async () => {
      try {
        const res = await axios.get(
          "http://localhost:8081/api/v1/books/search?keyword=" + query,
        );
        setBooks(res.data);
      } catch (err) {
        console.log(err);
      }
    }, 300);

    return () => clearTimeout(timeout);
  }, [query]);

  return (
    <div className="search-container">
      <input
        type="text"
        placeholder="Search books..."
        value={query}
        onFocus={() => setShow(true)}
        onBlur={() => setTimeout(() => setShow(false), 150)}
        onChange={(e) => setQuery(e.target.value)}
      />

      {show && books.length > 0 && (
        <div className="results">
          {books.map((book) => (
            <div
              key={book.id}
              className="item"
              onClick={() => setQuery(book.title)}
            >
              <div className="title">{book.title}</div>

              <div className="author">{book.author}</div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}
