import React, { useState } from 'react'

const AutoComplete = () => {
    const [text,setText] = useState();
  return (
    <div className='auto-complete-div'>
        <textarea name="" id="" onChange={e => setText(e.target.value)}>

        </textarea>
    </div>
  )
}

export default AutoComplete