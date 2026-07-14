import React, { useEffect, useRef } from 'react'
import {Link} from "react-router-dom"
import axios from "axios"
const CreateBooks = () => {
    const titre = useRef();
    const author = useRef();
    const description = useRef();

    const handle = async(e)=>{
        e.preventDefault();
        const data = {
          title: titre.current.value,
          author: author.current.value,
          descrition: description.current.value,
        };
        try {
            const res = await axios.post("http://localhost:8081/api/v1/books/add/book",data);
            console.log(res);
        } catch (error) {
            console.error(error);
        }
    }
  return (
    <div className='home-page'>
        <h1> Create books here :</h1>
        <form onSubmit={handle}>
            <label htmlFor="">Titre :</label>
            <input type="text" ref={titre} placeholder='titre' />
            <br />
            <label htmlFor="">author :</label>
            <input type="text" ref={author} placeholder='author' />
            <br />
            <label htmlFor="">description :</label>
            <textarea name="" id="" ref={description}>
            </textarea>
            <button type='submit'>add</button>
        </form>
        <br />
    <Link to={"/list"}>go to list books</Link>
    
    </div>
  )
}

export default CreateBooks