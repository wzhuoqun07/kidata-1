import Markdown from "markdown-to-jsx";

import createPageBase from "../components/PageLayout";

const exampleMarkdownContent = `
  This will soon be a fullscreen login page, but for now it's just *markdown!*
`

function LoginPage() {
  return createPageBase(
    <div className="page-card">
      <Markdown>{exampleMarkdownContent}</Markdown>
    </div>
  )
}

export default LoginPage;