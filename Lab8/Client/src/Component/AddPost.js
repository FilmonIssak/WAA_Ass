import React, { useState } from 'react'

export default function AddPost(props) {

    const [title, setTitle] = useState('')
    const [author, setAuthor] = useState('')
    const [content, setContent] = useState('')

    return (
        <div>
            <h1>Add Post</h1>
            <input onChange={(e) => setTitle(e.target.value)} placeholder='Enter Title' />
            <input onChange={(e) => setAuthor(e.target.value)} placeholder='Enter Author' />
            <input onChange={(e) => setContent(e.target.value)} placeholder='Enter Content' />
            <button onClick={() => props.addNewPost(title, author, content)}>ADD</button>
        </div>
    )
}
