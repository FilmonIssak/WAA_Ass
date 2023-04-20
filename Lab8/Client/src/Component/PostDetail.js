import axios from 'axios'
import React, { useEffect } from 'react'


export default function PostDetail({data, deletePost }) {
    const style = {
        border: "2px solid black",
        margin: "30px"
    }

    return (
        <div style={style}>
            <h1>{data.title}</h1>
            <h2>{data.author}</h2>
            <h2>{data.content}</h2>
            <p>This is the content in the post...</p>

            <button >edit</button>
            <button onClick={() => deletePost(data.id)}>delete</button>
        </div>
    )
}
