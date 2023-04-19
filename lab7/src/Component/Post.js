import React from 'react'

export default function Post({ id, title, author, handleToggle }) {

    return (

        <button onClick={() => handleToggle(id)} style={{ width: "100px" }} key={id}>
            <div style={{ margin: "10%" }}>
                <h1>{id}</h1>
                <h1>{title}</h1>
                <h1>{author}</h1>
            </div>
        </button>
    )
}
