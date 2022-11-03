// FIXME: ** TEMPORARY ** -- replace with fullscreen error page!

import Markdown from "markdown-to-jsx";

import createPageBase from "../components/PageLayout";

const exampleMarkdownContent = `
  <center>
    <h1>404</h1>
    Seems like you went to a page that doesn't exist. We don't support that (yet).
  </center>
`

function ErrorPage() {
  return createPageBase(
    <div className="page-card">
      <Markdown>{exampleMarkdownContent}</Markdown>
    </div>
  )
}

export default ErrorPage;