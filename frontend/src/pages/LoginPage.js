import Markdown from "markdown-to-jsx";

import createCardPage from "./createCardPage";

const exampleMarkdownContent = `
  This will soon be a fullscreen login page, but for now it's just *markdown!*
`

function LoginPage() {
  return createCardPage(
    <Markdown>{exampleMarkdownContent}</Markdown>
  )
}

export default LoginPage;